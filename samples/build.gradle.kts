plugins {
  application
  id("com.palantir.graal") version "0.6.0-74-g5306dc5"
}

val entrypoint = "edu.umontreal.kotlingrad.samples.HelloKotlingradKt"

application.mainClassName = entrypoint
graal {
  mainClass(entrypoint)
  outputName("hello-kotlingrad")
}

repositories {
  maven("https://maven.jzy3d.org/releases")
  maven("https://jetbrains.bintray.com/lets-plot-maven")
  maven("https://dl.bintray.com/egor-bogomolov/astminer/")
}

dependencies {
  implementation(project(":core"))
  implementation(kotlin("stdlib-jdk8"))

  // Graphical libraries
  implementation("guru.nidi:graphviz-kotlin:0.17.0")
  implementation("org.jzy3d:jzy3d-api:1.0.2")

  implementation("com.github.lejon.T-SNE-Java:tsne:v2.5.0")
  implementation("io.github.vovak.astminer:astminer:0.5")

  val ejmlVersion = "0.39"
  implementation("org.ejml:ejml-kotlin:$ejmlVersion")
  implementation("org.ejml:ejml-all:$ejmlVersion")
  implementation("org.jetbrains.lets-plot-kotlin:lets-plot-kotlin-api:1.0.0")

  implementation("org.nield:kotlin-statistics:1.2.1")
}

//javafx.modules("javafx.controls", "javafx.swing")

tasks {
  listOf(
    "HelloKotlingrad", "Plot2D", "Plot3D", "VisualizeDFG", "VariableCapture",
    "LetsPlot", "ScalarDemo", "VectorDemo", "MatrixDemo",
    "MLP", "LinearRegression", "PolynomialRegression",
    "PolynomialAttack", "ReadSeff", "Code2Vec"
  ).forEach { fileName ->
    register(fileName, JavaExec::class) {
      main = "edu.umontreal.kotlingrad.samples.${fileName}Kt"
      classpath = sourceSets["main"].runtimeClasspath
    }
  }

  test {
    dependsOn("ScalarDemo", "MatrixDemo", "VectorDemo", "VariableCapture")
  }
}