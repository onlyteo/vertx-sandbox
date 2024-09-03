# Vert.x REST API

This example shows a React frontend and Vert.x REST API.

## Architecture

The example consists of a `Frontend` and a `Backend` application.

```mermaid
graph TD
    subgraph Frontend
        A[REST Client]:::react
    end
    subgraph Frontend API
        B[REST API]:::vertx
    end
    subgraph Backend
        C[REST API]:::vertx
    end

    A -- REST --> B
    B-- REST --> C

    classDef react fill: #58c4dc, stroke: #000000, color: #000000
    classDef vertx fill: #782b90, stroke: #000000, color: #ffffff
```

The `Frontend` application communicates with the `Backend` application using REST.
