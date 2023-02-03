# WordWriter [![Release](https://jitpack.io/v/QiXi/word-writer.svg?style=flat-square)](https://jitpack.io/#QiXi/word-writer)
Typewriter animation text in Compose UI

## Usage

```kotlin
val textTypewriter = remember {
    mutableStateOf("use Typewriter")
}
Text(
    modifier = Modifier.fillMaxSize(),
    text = Typewriter(
        writer = TypewriterData(),
        text = textTypewriter
    ) {
        textTypewriter.value = "finish!"
    },
    style = TextStyle(color = Color.Transparent)
)
```
or
```kotlin
val textTypewriter = remember {
    mutableStateOf("use Wordwriter")
}
Text(
    modifier = Modifier.fillMaxSize(),
    text = Typewriter(
        writer = WordwriterData(),
        text = textWordwriter
    ),
    style = TextStyle(color = Color.Transparent)
)
```

## Setup
1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:
```groovy
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
} 
```
2. Add the dependency
```groovy
dependencies {
    // WordWriter
    implementation 'com.github.QiXi:word-writer:0.1.0'
}
```