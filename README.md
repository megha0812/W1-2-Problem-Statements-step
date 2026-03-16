# Hash Table Based Systems – Java Implementations

## Overview

This project contains **Java implementations of ten real-world systems built using hash tables and related data structures**.
The goal of the project is to demonstrate how **hash maps, sets, arrays, and linked hash maps** can be used to build scalable and efficient systems commonly used in modern software platforms.

Each problem simulates a **practical application scenario** such as username availability checking, flash-sale inventory management, DNS caching, plagiarism detection, analytics dashboards, and caching systems.

The implementations are **simplified for learning purposes** and focus on core **Data Structures and Algorithms (DSA)** concepts such as:

* Hash tables and key-value mapping
* O(1) lookup performance
* Collision handling
* Frequency counting
* Time-based cache expiration
* Open addressing
* Rate limiting algorithms
* Multi-level caching strategies

---

# Project Structure

The project is implemented in a **single Java file** containing multiple classes.
Each class represents one problem scenario.

```
SystemsDemo.java
│
├── UsernameChecker        (Problem 1)
├── InventoryManager       (Problem 2)
├── DNSCache + DNSEntry    (Problem 3)
├── PlagiarismDetector     (Problem 4)
├── Analytics              (Problem 5)
├── RateLimiter + TokenBucket (Problem 6)
├── AutoComplete           (Problem 7)
├── ParkingLot             (Problem 8)
├── TwoSum                 (Problem 9)
└── MultiCache             (Problem 10)
```

The `SystemsDemo` class contains the **main() method** used to demonstrate each system.

---

# Problems Implemented

## 1. Social Media Username Availability Checker

Simulates a registration system similar to **Twitter or Instagram**.

### Features

* O(1) username lookup using HashMap
* Username availability check
* Username suggestion generator
* Tracks frequency of attempted usernames

### Data Structures

* `HashMap<String, Integer>` for username → userId
* `HashMap<String, Integer>` for attempt frequency

---

## 2. E-commerce Flash Sale Inventory Manager

Simulates high-traffic flash sales such as **Amazon Prime Day**.

### Features

* Real-time stock tracking
* O(1) purchase processing
* Thread-safe purchase handling
* Waiting list management

### Data Structures

* `HashMap<productId, stock>`
* `LinkedHashMap` for FIFO waiting list

---

## 3. DNS Cache with TTL

A simplified DNS caching system similar to browser DNS caches.

### Features

* Domain → IP mapping
* TTL (Time To Live) expiration
* Cache hit/miss tracking
* Automatic refresh on expiry

### Data Structures

* `HashMap<String, DNSEntry>`

---

## 4. Plagiarism Detection System

Detects similarity between documents using **n-grams**.

### Features

* Text broken into n-grams
* Hash-based storage of document references
* Similarity detection via matching n-grams

### Data Structures

* `HashMap<String, Set<DocumentId>>`

---

## 5. Real-Time Website Analytics Dashboard

Simulates a **real-time traffic analytics system**.

### Features

* Page view tracking
* Unique visitor counting
* Traffic source statistics
* Real-time dashboard updates

### Data Structures

* `HashMap<pageUrl, visitCount>`
* `HashMap<pageUrl, Set<userId>>`
* `HashMap<source, count>`

---

## 6. Distributed Rate Limiter

Implements a **Token Bucket rate limiting algorithm** similar to API gateways.

### Features

* Tracks requests per client
* Limits requests per hour
* Allows burst traffic
* Prevents API abuse

### Data Structures

* `HashMap<clientId, TokenBucket>`

---

## 7. Search Engine Autocomplete System

A simplified autocomplete system similar to **Google search suggestions**.

### Features

* Stores query frequency
* Returns top suggestions for a prefix
* Updates popularity dynamically

### Data Structures

* `HashMap<query, frequency>`

---

## 8. Smart Parking Lot Management

Implements parking allocation using **open addressing with linear probing**.

### Features

* Hash-based spot assignment
* Collision resolution using linear probing
* Parking spot tracking

### Data Structures

* Array-based hash table

---

## 9. Two-Sum Financial Transaction Detection

Used for fraud detection and transaction analysis.

### Features

* Finds pairs of transactions matching a target amount
* Detects complementary transactions efficiently

### Data Structures

* `HashMap` for complement lookup

---

## 10. Multi-Level Cache System

Simulates a **video streaming service cache** like Netflix.

### Cache Layers

* **L1 Cache** – In-memory (fastest)
* **L2 Cache** – Secondary storage
* **L3 Cache** – Database

### Features

* LRU caching
* Cache promotion
* Cache hit tracking

### Data Structures

* `LinkedHashMap` for LRU cache
* `HashMap` for secondary cache

---

# Technologies Used

* **Programming Language:** Java

* **Data Structures:**

    * HashMap
    * HashSet
    * LinkedHashMap
    * Arrays
    * Priority structures

* **Concepts Applied:**

    * Hashing
    * Collision resolution
    * Frequency counting
    * Time-based caching
    * Rate limiting algorithms
    * Real-time analytics processing

---

# How to Run the Project

### 1. Compile the program

```bash
javac SystemsDemo.java
```

### 2. Run the program

```bash
java SystemsDemo
```

---

# Learning Outcomes

After studying this project, you will understand:

* Practical uses of **hash tables in real systems**
* How **O(1) lookup** improves performance
* How to build **high-performance data systems**
* Implementation of **rate limiting, caching, analytics, and search suggestions**
* How different systems rely on **efficient data structures**

---

# Future Improvements

Possible enhancements include:

* Implementing **thread-safe concurrent collections**
* Adding **database integration**
* Implementing **Trie for autocomplete optimization**
* Adding **real benchmarking for performance comparison**
* Implementing **distributed cache architecture**

---

# Conclusion

This project demonstrates how **hash tables power many real-world systems** used in modern platforms such as:

* Social media platforms
* E-commerce websites
* Search engines
* Cloud APIs
* Streaming platforms

Understanding these implementations helps build **efficient, scalable backend systems** using core data structure concepts.

---
