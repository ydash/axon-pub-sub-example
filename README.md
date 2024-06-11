# AXONを利用したPub/Subパターンのサンプル

## 概要

AXONを利用してPub/Subパターンを実装するサンプルです。

## 実装方法

### 1. 依存関係の追加

[`build.gradle`](build.gradle.kts)に以下の依存関係を追加します。

```groovy
implementation("org.axonframework:axon-spring-boot-starter:4.9.3")
implementation("org.springframework.boot:spring-boot-starter-web")
```

### 2. コマンドクラスの作成

コマンドクラスを作成します。

```java
package com.example.axon_pub_sub_pattern.message;

import java.util.UUID;

public sealed interface MessageInterface permits BarMessage, BazMessage, FooMessage {
    UUID id();
    String message();
}
```

```java
package com.example.axon_pub_sub_pattern.message;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

public record FooMessage(@TargetAggregateIdentifier UUID id, String message) implements MessageInterface {
}
```