# Vert.x Sandbox

[![Kotlin](https://img.shields.io/badge/kotlin-2.0.10-8d53f9.svg?logo=kotlin&logoColor=8d53f9)](http://kotlinlang.org)
[![TypeScript](https://img.shields.io/badge/typescript-5.2.2-3178c6.svg?logo=typescript&logoColor=3178c6)](https://www.typescriptlang.org)
[![Vert.x](https://img.shields.io/badge/vertx-4.5.9-782b90.svg?logo=java&logoColor=fdb71c)](https://microprofile.io)
[![React](https://img.shields.io/badge/react-18.3.1-58c4dc.svg?logo=react&logoColor=58c4dc)](https://react.dev)
[![Gradle](https://img.shields.io/badge/gradle-stable-209bc4.svg?logo=gradle&logoColor=209bc4)](https://gradle.org)
[![Gradle](https://img.shields.io/badge/node.js-stable-417e38.svg?logo=nodedotjs&logoColor=417e38)](https://nodejs.org)
[![GitHub license](https://img.shields.io/badge/license-Apache_2.0-e97726.svg)](https://www.apache.org/licenses/LICENSE-2.0)

This repository contain sandbox projects to showcase features of the [Vert.x framework](https://vertx.io).

All examples are written in [Kotlin](https://kotlinlang.org) and built using [Gradle](https://gradle.org).

## Examples
Read details about the examples in their respective project roots.

## Architecture
[Vert.x](https://vertx.io) is a lightweight framework for building applications for the
[JVM runtime](https://en.wikipedia.org/wiki/Java_virtual_machine).

The examples typically consists of a `Frontend` and a `Backend` application.

```mermaid
graph TD
    A[Vert.x Frontend]
    B[Vert.x Backend]

    A:::vertx --> B:::vertx
    
    classDef react fill: #58c4dc, stroke: #000000, color: #000000
    classDef vertx fill: #782b90, stroke: #000000, color: #ffffff
```

If the frontend is a JavaScript application then there is often also a `Frontend API` application.

```mermaid
graph TD
    A[React Frontend]
    B[Vert.x Frontend API]
    C[Vert.x Backend]
    
    A:::react --> B:::microprofile
    B:::vertx --> C:::vertx
    
    classDef react fill: #58c4dc, stroke: #000000, color: #000000
    classDef vertx fill: #782b90, stroke: #000000, color: #ffffff
```

## Use case
Most examples implement a "hello world" style logic that returns a greeting message when the user inputs a name.

* A user inputs the name "John" and clicks "Submit"
* The system generates a greeting "Hello John!" back to the user
