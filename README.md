# 🔢 Calculator App

<div align="center">
  
  ![Android](https://img.shields.io/badge/Platform-Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
  ![Java](https://img.shields.io/badge/Language-Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
  ![Material Design](https://img.shields.io/badge/Design-Material-757575?style=for-the-badge&logo=materialdesign&logoColor=white)
  
</div>

## 📋 Overview

**Calculator App** is a clean and functional Android calculator application built with Java. It provides essential arithmetic operations with a user-friendly interface, making it perfect for everyday calculations.

## ✨ Key Features

- **➕ Basic Operations**: Addition, subtraction, multiplication, division
- **🔢 Decimal Support**: Handle decimal numbers with precision
- **⌫ Backspace**: Delete last entered digit
- **🔄 Clear Function**: Clear current calculation (C) and all (AC)
- **📱 Responsive UI**: Clean and intuitive button layout
- **🎨 Material Design**: Modern Android design guidelines
- **📊 Display**: Large, easy-to-read result display
- **⚡ Fast Performance**: Instant calculation results

## 🛠️ Tech Stack

- **Language**: Java
- **UI**: XML Layouts with Material Design
- **Architecture**: MVC (Model-View-Controller)
- **Min SDK**: Android 5.0 (API 21)
- **Build System**: Gradle

## 📱 App Features

### Arithmetic Operations
- **Addition (+)**: Add two or more numbers
- **Subtraction (-)**: Subtract numbers
- **Multiplication (×)**: Multiply numbers
- **Division (÷)**: Divide numbers with zero-check

### Additional Functions
- **Decimal Point (.)**: Support for floating-point numbers
- **Clear (C)**: Clear current entry
- **All Clear (AC)**: Reset calculator
- **Backspace (⌫)**: Delete last digit
- **Equals (=)**: Calculate result

### UI Components
- Large display screen
- Number buttons (0-9)
- Operation buttons (+, -, ×, ÷)
- Function buttons (C, AC, =)
- Decimal point button

## 🎨 Design

### Layout
```
┌─────────────────────────┐
│     Display Screen      │
├─────────────────────────┤
│  AC   C    ⌫    ÷      │
│  7    8    9    ×      │
│  4    5    6    -      │
│  1    2    3    +      │
│  0    .    =           │
└─────────────────────────┘
```

### Color Scheme
- **Primary**: Modern accent colors
- **Background**: Clean white or dark theme
- **Buttons**: Distinct colors for numbers and operations
- **Display**: High contrast for readability

## 🚀 Getting Started

### Prerequisites

- Android Studio Arctic Fox or later
- Android SDK 21 or higher
- Java Development Kit (JDK) 8+

### Installation

1. **Clone the repository**:
```bash
git clone https://github.com/AhmedSh10/Calculator-App.git
```

2. **Open in Android Studio**

3. **Sync Gradle dependencies**

4. **Build and run the project**

## 📂 Project Structure

```
app/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/calculator/
│   │   │       ├── MainActivity.java
│   │   │       ├── Calculator.java
│   │   │       └── utils/
│   │   ├── res/
│   │   │   ├── layout/
│   │   │   │   └── activity_main.xml
│   │   │   ├── values/
│   │   │   │   ├── colors.xml
│   │   │   │   ├── strings.xml
│   │   │   │   └── styles.xml
│   │   │   └── drawable/
│   │   └── AndroidManifest.xml
```

## 🔧 Implementation

### Calculator Logic
```java
public class Calculator {
    private double operand1;
    private double operand2;
    private String operator;
    
    public double calculate() {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "×":
                return operand1 * operand2;
            case "÷":
                if (operand2 != 0) {
                    return operand1 / operand2;
                }
                throw new ArithmeticException("Division by zero");
            default:
                return 0;
        }
    }
}
```

### Button Click Handling
```java
public void onNumberClick(View view) {
    Button button = (Button) view;
    String number = button.getText().toString();
    currentInput += number;
    updateDisplay();
}

public void onOperatorClick(View view) {
    Button button = (Button) view;
    operator = button.getText().toString();
    operand1 = Double.parseDouble(currentInput);
    currentInput = "";
}

public void onEqualsClick(View view) {
    operand2 = Double.parseDouble(currentInput);
    double result = calculator.calculate();
    displayResult(result);
}
```

## 🎯 Use Cases

- **Daily Calculations**: Quick arithmetic operations
- **Shopping**: Calculate totals and discounts
- **Learning**: Educational tool for students
- **Finance**: Basic financial calculations
- **General Purpose**: Everyday math needs

## 🔮 Future Enhancements

- [ ] Scientific calculator mode
- [ ] History of calculations
- [ ] Memory functions (M+, M-, MR, MC)
- [ ] Percentage calculations
- [ ] Square root and power functions
- [ ] Dark mode toggle
- [ ] Landscape orientation support
- [ ] Haptic feedback
- [ ] Sound effects (optional)
- [ ] Copy result to clipboard

## 🐛 Error Handling

- **Division by Zero**: Displays error message
- **Invalid Input**: Prevents invalid operations
- **Overflow**: Handles large numbers gracefully
- **Format Errors**: Validates decimal input

## 🤝 Contributing

Contributions are welcome! Feel free to:
- Add new features
- Improve UI/UX
- Fix bugs
- Optimize code
- Enhance documentation

## 📄 License

This project is available for educational and personal use.

## 👨‍💻 Developer

**Ahmed Shaaban**

- GitHub: [@AhmedSh10](https://github.com/AhmedSh10)
- LinkedIn: [Ahmed Shaaban](https://linkedin.com/in/ahmed-shaaban)

## 🙏 Acknowledgments

- Android documentation
- Material Design guidelines
- Java programming community

## 📚 Learning Resources

This project is great for learning:
- Android UI development
- Java programming basics
- Event handling in Android
- Material Design implementation
- Basic app architecture

---

<div align="center">
  
  **⭐ If you find this project useful, please consider giving it a star!**
  
  **🔢 Calculate with confidence!**
  
</div>
