package edu.mcgill.shipshape

import org.gradle.api.*
import java.io.File

open class Shipshape: Plugin<Project> {
  val header = """// This file was generated by Shipshape
    
    package edu.umontreal.kotlingrad.shapes
    
    import edu.umontreal.kotlingrad.api.*
    """.trimIndent()

  fun generateShapes() = """
      $header
      
      // Dimensions ================================
      ${genDim()}
      // Vectors ===================================
      ${genVec()}
      // Matrices ==================================
      ${genMat()}
      // Derivatives ===============================
      ${genDif()}
    """.trimIndent()

  override fun apply(project: Project) {
    project.run {
      tasks.register("genShapes") {
        val shapes = generateShapes()

        // TODO: Parameterize this path
        val outputDir = "$projectDir/src/main/kotlin/gen"
        try {
          File(outputDir).mkdirs()
          File("$outputDir/Shapes.kt")
            .also { it.createNewFile() }
            .writeText(shapes)
        } catch (e: Exception) {
          logger.error(outputDir)
          throw e
        }
      }
    }
  }
}
