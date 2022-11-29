package main

import (
	"bufio"
	"fmt"
	"log"
	"os"
	"strconv"
	"strings"
)

func dict() map[string]string {
	m := make(map[string]string)
	m["I"] = "1"
	m["II"] = "2"
	m["III"] = "3"
	m["IV"] = "4"
	m["V"] = "5"
	m["VI"] = "6"
	m["VII"] = "7"
	m["VIII"] = "8"
	m["IX"] = "9"

	m["X"] = "10"
	m["XX"] = "20"
	m["XXX"] = "30"
	m["XL"] = "40"
	m["L"] = "50"
	m["LX"] = "60"
	m["LXX"] = "70"
	m["LXXX"] = "80"
	m["CX"] = "90"
	m["C"] = "100"
	return m
}

func reader() ([]string, error) {
	fmt.Print("Enter a grade: ")
	reader1 := bufio.NewReader(os.Stdin)
	input, _ := reader1.ReadString('\n')
	input = strings.TrimSpace(input)
	input_1 := strings.Fields(input)
	if len(input_1) < 3 {
		return input_1, fmt.Errorf("Вывод ошибки, так как строка не является математической операцией.")
	}
	if len(input_1) > 3 {
		return input_1, fmt.Errorf("Вывод ошибки, так как формат математической операции не удовлетворяет заданию — два операнда и один оператор (+, -, /, *).")
	}
	return input_1, nil
}

func main() {
	input, err := reader()
	if err != nil {
		log.Fatal(err)
	}
	firstNumber := input[0]
	count1 := 0
	count2 := 0
	secondNumber := input[2]
	sign := input[1]
	m := dict()
	for key, _ := range m {
		if key == input[0] {
			firstNumber = m[key]
			count1 = 1
		}
		if key == input[2] {
			count2 = 1
			secondNumber = m[key]
		}
	}
	if count1 != count2 {
		log.Fatal(fmt.Errorf("Вывод ошибки, так как используются одновременно разные системы счисления."))
	}
	firstNumber1, _ := strconv.Atoi(firstNumber)
	secondNumber2, _ := strconv.Atoi(secondNumber)

	switch sign {
	case "+":
		if count1 == 1 && count2 == 1 {
			result := firstNumber1 + secondNumber2
			celoe := result / 10
			ostat := result % 10
			if celoe == 0 {
				ostat1 := " "
				for key, value := range m {
					value1, _ := strconv.Atoi(value)
					if ostat == value1 {
						ostat1 = key
					}
				}
				fmt.Println(ostat1)
			} else {
				ostat1 := " "
				celoe1 := "X"
				if ostat == 0 {
					ostat1 = "X"
				}
				for key, value := range m {
					value1, _ := strconv.Atoi(value)
					if ostat == value1 {
						ostat1 = key
					}
				}
				fmt.Println(celoe1 + ostat1)
			}

		} else {
			result := firstNumber1 + secondNumber2
			fmt.Println(result)
		}
	case "-":
		if count1 == 1 && count2 == 1 && firstNumber1-secondNumber2 < 0 {
			log.Fatal(fmt.Errorf("Вывод ошибки, так как в римской системе нет отрицательных чисел."))
		}
		if count1 == 1 && count2 == 1 {
			ostat1 := " "
			result := firstNumber1 - secondNumber2
			if result == 0 {
				ostat1 = "Number 0 is none"
			}
			for key, value := range m {
				value1, _ := strconv.Atoi(value)
				if result == value1 {
					ostat1 = key
				}
			}
			fmt.Println(ostat1)
		} else {
			result := firstNumber1 - secondNumber2
			fmt.Println(result)
		}

	case "*":
		if count1 == 1 && count2 == 1 {
			result := firstNumber1 * secondNumber2
			celoe := result / 10
			ostat := result % 10
			if celoe == 0 {
				ostat1 := " "
				for key, value := range m {
					value1, _ := strconv.Atoi(value)
					if ostat == value1 {
						ostat1 = key
					}
				}
				fmt.Println(ostat1)
			}
			if ostat == 0 {
				celoe1 := " "
				for key, value := range m {
					value1, _ := strconv.Atoi(value)
					if result == value1 {
						celoe1 = key
					}
				}
				fmt.Println(celoe1)
			}
			if celoe != 0 && ostat != 0 {
				ostat1 := " "
				celoe1 := " "
				for key, value := range m {
					value1, _ := strconv.Atoi(value)
					if ostat == value1 {
						ostat1 = key
					}
					if celoe*10 == value1 {
						celoe1 = key
					}
				}
				fmt.Println(celoe1 + ostat1)
			}

		} else {
			result := firstNumber1 + secondNumber2
			fmt.Println(result)
		}

	case "/":
		if count1 == 1 && count2 == 1 {
			ostat1 := " "
			result := firstNumber1 / secondNumber2
			for key, value := range m {
				value1, _ := strconv.Atoi(value)
				if result == value1 {
					ostat1 = key
				}
			}
			fmt.Println(ostat1)
		} else {
			fmt.Println(firstNumber1 / secondNumber2)
		}
	}
}
