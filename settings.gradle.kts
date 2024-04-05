pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "FoodShopTest"
include(":app")
include(":features-mobile")
include(":core")
include(":features-mobile:splashscreen")
include(":features-mobile:palette")
include(":core:navigation")
include(":features-mobile:menu")
include(":features-mobile:common")
include(":core:network")
include(":core:utils")
include(":features-mobile:itemcard")
include(":core:database")
include(":features-mobile:cart")
