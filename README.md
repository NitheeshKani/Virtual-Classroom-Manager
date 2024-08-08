# Classroom Management CLI

This is a simple command-line interface (CLI) for managing classrooms, students, and assignments. This Java application allows you to create classrooms, add or remove students, assign assignments, and more.

## Table of Contents

- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Commands](#commands)
- [Contributing](#contributing)
- [License](#license)

## Features

- Create and list classrooms
- Add and remove students from classrooms
- Assign and submit assignments for students
- Navigate through classrooms and students using commands

## Installation

1. **Clone the repository**:
    ```bash
    git clone https://github.com/your-username/classroom-management-cli.git
    ```
2. **Navigate to the project directory**:
    ```bash
    cd classroom-management-cli
    ```
3. **Compile the Java files**:
    ```bash
    javac Cmd.java
    ```
4. **Run the application**:
    ```bash
    java Cmd
    ```

## Usage

Once you run the application, you will be able to use various commands to manage classrooms and students. Type `help` to see the list of available commands.

## Commands

### General Commands
- `help` - Display the help message
- `exit` - Exit the program

### Classroom Commands
- `list` - List all classrooms
- `new <classroom_name>` - Create a new classroom
- `cd <classroom_name>` - Change the current classroom
- `.` - Unselect the current classroom

### Student Commands
- `add <student_name>` - Add a student to the current classroom
- `del <student_name>` - Remove a student from the current classroom
- `list` - List all students in the current classroom
- `cd <student_name>` - Change the current student
- `.` - Unselect the current student

### Assignment Commands
- `assign <assignment_name>` - Assign an assignment to the selected student
- `submit <assignment_name>` - Submit an assignment for the selected student
- `list` - List all assignments for the selected student

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes. Make sure to follow the coding style and add tests for any new features.

1. **Fork the repository**
2. **Create a new branch** (`git checkout -b feature/your-feature`)
3. **Commit your changes** (`git commit -am 'Add new feature'`)
4. **Push to the branch** (`git push origin feature/your-feature`)
5. **Create a new Pull Request**

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
