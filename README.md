# redis-with-sql
This repo shows how using redis can reduce fetching data from redis server is more efficient than the actual database.


🚀 Integrating Redis with Your Spring Boot App: Why, When & How

If you're building a modern web application with Spring Boot and care about speed, scalability, and performance, then Redis is a tool you should definitely know. Here’s a closer look at how Redis works in tandem with Spring Boot caching annotations and a detailed pros/cons breakdown.

🔧 What Is Redis?
Redis is a super-fast, in-memory key-value store. Think of it as a giant, ultra-fast dictionary your app can use to store and retrieve data almost instantly ⚡

💡 Common Use Cases in Spring Boot Apps:

Caching database queries: Speed up responses by caching expensive operations.

Storing session data: Maintain user sessions without burdening your relational database.

Rate limiting: Control repetitive actions (e.g., login attempts) in real time.

Queues for background tasks: Use Redis' data structures to manage job queues efficiently.


🛠 How to Integrate Redis with Spring Boot (High-Level Steps):

1. Add the Redis Dependency:
Add the following to your pom.xml:

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>

2. Configure Redis in application.properties:

spring.redis.host=localhost
spring.redis.port=6379

3. Implement Caching with Spring’s Annotations:
Use annotations such as @Cacheable, @CachePut, and @CacheEvict to manage your caches seamlessly.

4. Deploy a Redis Server:
Run Redis locally or use a managed solution like AWS ElastiCache or Azure Redis.


🔍 Understanding Spring Boot Caching Annotations

Spring Boot provides easy-to-use annotations to handle caching behaviors. Here’s what each annotation does and when to use them:

1. @Cacheable
-> What It Does:
Caches the result of a method call. The first time the method is invoked, the result is stored; subsequent calls with the same parameters return the cached result, bypassing the method execution.

-> When to Use:
Use @Cacheable for methods with results that are expensive to compute or retrieve, and when the data doesn’t change frequently.

-> Example Use Case:
Caching a lookup from a database table that rarely changes.

-> Why It’s Beneficial:

Reduces database hits

Improves application performance

Simple to implement with minimal code changes

2. @CachePut
-> What It Does:
Updates the cache with the result of the method every time it’s called, regardless of whether the cache already contains the data.

-> When to Use:
Use @CachePut when you want to update the cached value along with executing the method—ideal for write operations or when you're modifying data.

-> Example Use Case:
Updating user information in both the database and cache after an edit operation.

-> Why It’s Beneficial:

Ensures that the cache always contains the latest data

Useful for synchronizing cache state with updates or modifications

3. @CacheEvict
-> What It Does:
Clears specified entries from the cache. This is useful when you know that the data may have changed or is no longer valid.

-> When to Use:
Use @CacheEvict for methods that delete or alter data so that stale data is not served to users.

-> Example Use Case:
Removing a user’s cached data after they update or delete their profile information.

-> Why It’s Beneficial:

Prevents serving outdated or incorrect data from the cache

Maintains cache hygiene and consistency with the underlying database