# Pixelora

Pixelora is a full-stack web application that serves as a photo library, allowing users to insert, delete, and download images. The backend is built using Java, JSP, Hibernate, Spring, Spring Boot, and RESTful APIs, while the frontend is developed with JavaScript and React.

## Table of Contents

- [Features](#features)
- [Architecture](#architecture)
- [Technologies](#technologies)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Features

- User authentication and authorization
- Upload, delete, and download images
- Search and browse photos
- Responsive design for various devices

## Architecture

The application is divided into two main parts:

1. **Backend**: Manages the data, business logic, and APIs.
2. **Frontend**: Handles the user interface and experience.

## Technologies

### Backend

- **Java**: Core programming language
- **Spring Boot**: Framework for building the backend
- **Spring MVC**: Web framework
- **Hibernate**: ORM tool for database interactions
- **JSP**: Java Server Pages for server-side rendering
- **RESTful API**: For client-server communication
- **MySQL/H2 Database**: Database for storing image metadata and user information

### Frontend

- **JavaScript**: Core programming language
- **React**: Library for building user interfaces
- **HTML/CSS**: Markup and styling

## Getting Started

### Prerequisites

- Java 17
- Node.js (v14 or later)
- MySQL (for production) / H2 Database (for development)

### Backend Setup

1. **Clone the repository**

    ```bash
    git clone https://github.com/yourusername/Pixelora.git
    cd Pixelora
    ```

2. **Set up the backend**

    - Open the project in your favorite IDE
    - Configure the database connection in `src/main/resources/application.properties`

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/Pixelora
    spring.datasource.username=yourusername
    spring.datasource.password=yourpassword
    spring.jpa.hibernate.ddl-auto=update
    ```

3. **Build and run the backend**

    ```bash
    ./mvnw clean install
    ./mvnw spring-boot:run
    ```

### Frontend Setup

1. **Navigate to the frontend directory**

    ```bash
    cd frontend
    ```

2. **Install dependencies**

    ```bash
    npm install
    ```

3. **Start the frontend development server**

    ```bash
    npm start
    ```

## Usage

1. Open your browser and navigate to `http://localhost:8080`
2. Register a new user or log in with existing credentials
3. Upload, delete, and download images
4. Browse and search for images

## Contributing

We welcome contributions! Please fork the repository and submit pull requests.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

Distributed under the MIT License. See `LICENSE` for more information.
