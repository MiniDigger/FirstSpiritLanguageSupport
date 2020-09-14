package com.github.minidigger.firstspiritlanguagesupport.services

import com.intellij.openapi.project.Project
import com.github.minidigger.firstspiritlanguagesupport.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
