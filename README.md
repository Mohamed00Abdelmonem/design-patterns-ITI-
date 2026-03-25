"# Design Patterns Library Management System

A comprehensive Java implementation demonstrating various design patterns in a library management system context.

## Overview

This project showcases the practical application of classic design patterns through a library management system. The system handles book borrowing, returning, and user management while demonstrating clean code principles and object-oriented design.

## Implemented Design Patterns

### 1. **Singleton Pattern**
- **Location**: `LibraryFacade`, `LibraryService`
- **Purpose**: Ensures a single instance of the library service and provides a global access point

### 2. **Factory Method Pattern**
- **Location**: `BookFactory`
- **Purpose**: Creates different types of books (Physical, EBook, Historical) without exposing the creation logic

### 3. **Decorator Pattern**
- **Location**: `PremiumBookDecorator`
- **Purpose**: Adds premium features (extra borrowing days) to books dynamically

### 4. **Proxy Pattern**
- **Location**: `EBookProxy`
- **Purpose**: Controls access to e-books based on user premium status

### 5. **Adapter Pattern**
- **Location**: `BookAdapter`, `ExternalBookData`
- **Purpose**: Integrates external book data with the internal library system

### 6. **Observer Pattern**
- **Location**: `UserNotificationObserver`, `LibraryService`
- **Purpose**: Notifies users when books become available

### 7. **Chain of Responsibility Pattern**
- **Location**: `BorrowHandler` chain (Librarian → Manager → Director)
- **Purpose**: Handles book borrowing requests with different approval levels

## Project Structure

```
src/
├── LibrarySystemDemo.java          # Main demonstration class
└── library/
    ├── core/
    │   ├── Book.java                # Base book implementation
    │   ├── BookInterface.java      # Book contract interface
    │   └── User.java                # User entity
    ├── models/
    │   ├── EBook.java              # E-book implementation
    │   ├── PhysicalBook.java       # Physical book implementation
    │   └── HistoricalBook.java     # Historical book implementation
    ├── adapter/
    │   ├── BookAdapter.java        # Adapter for external book data
    │   └── ExternalBookData.java   # External book data structure
    ├── decorator/
    │   └── PremiumBookDecorator.java # Premium features decorator
    ├── proxy/
    │   └── EBookProxy.java         # Access control proxy
    ├── factory/
    │   └── BookFactory.java        # Book creation factory
    ├── facade/
    │   └── LibraryFacade.java      # System facade
    ├── service/
    │   └── LibraryService.java     # Core library service (Singleton)
    ├── observer/
    │   └── UserNotificationObserver.java # User notifications
    └── chain/
        ├── BorrowHandler.java      # Chain base interface
        ├── BorrowRequest.java      # Request data structure
        ├── LibrarianHandler.java   # First handler in chain
        ├── ManagerHandler.java     # Second handler in chain
        └── DirectorHandler.java    # Final handler in chain
```

## Key Features

- **Type-safe book creation** using Factory Method pattern
- **Role-based access control** for premium e-books using Proxy pattern
- **Dynamic feature enhancement** using Decorator pattern
- **External data integration** using Adapter pattern
- **Real-time notifications** using Observer pattern
- **Approval workflow** using Chain of Responsibility pattern
- **Comprehensive validation** and error handling
- **Clean, documented code** following Java best practices

## How to Run

1. Compile the source code:
   ```bash
   javac src/LibrarySystemDemo.java
   ```

2. Run the demonstration:
   ```bash
   java LibrarySystemDemo
   ```

## Code Quality Improvements

This refactored version includes:

- **Proper encapsulation** with private fields and validation
- **Comprehensive JavaDoc documentation** for all public APIs
- **Input validation** with meaningful error messages
- **Constants for repeated strings** to improve maintainability
- **Clean naming conventions** following Java standards
- **Separation of concerns** with well-defined responsibilities
- **Immutable fields** where appropriate
- **Consistent error handling** throughout the system

## Design Principles Applied

- **Single Responsibility Principle**: Each class has one clear purpose
- **Open/Closed Principle**: Classes are open for extension, closed for modification
- **Liskov Substitution Principle**: Subtypes can replace their base types
- **Interface Segregation Principle**: Interfaces are focused and cohesive
- **Dependency Inversion Principle**: Depend on abstractions, not concretions

## Technologies Used

- **Java 8+**: Core programming language
- **Object-Oriented Design**: Primary architectural approach
- **Design Patterns**: Gang of Four patterns implementation

## Author

ITI Design Patterns Course - Practical Implementation Project" 
