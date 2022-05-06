// var fullName = prompt("Enter your name");
// var firstChar = fullName.slice(0, 1);
// var anotherChar = fullName.slice(1);
// fullName = firstChar.toUpperCase() + anotherChar.toLowerCase();
// alert("Hello " + fullName);
// console.log(fullName);
// var output = [];
// var count = 1;

// function fizzBuzz() {
//     if (count % 3 === 0) {
//         if (count % 5 == 0) {
//             output.push("Fizz Buzz");
//         } else {
//             output.push("Fizz");
//         }
//     } else {
//         if (count % 5 == 0) {
//             output.push("Buzz");
//         } else {
//             output.push(count);
//         }
//     }

//     count++;
//     console.log(output);
// }
// fizzBuzz();

// prompt("enter your name:");
// prompt("enter your partner's name:");
// var loveCal = Math.random();
// loveCal = loveCal * 100;
// loveCal = Math.floor(loveCal) + 1;
// alert("your love calculator is:" + loveCal + "%");

// function getMilk(money, costperBottle) {
//     console.log("Buy" + calcBottle(money, costperBottle));
//     return calcChange(money, costperBottle);
// }

// function calcBottle(startingMoney, costperBottle) {
//     var numberofBottle = Math.floor(startingMoney / costperBottle);
//     return numberofBottle;
// }

// function calcChange(startingAmount, costperBottle) {
//     var change = startingAmount % costperBottle;
//     return change;
// }
// console.log("hello, your change is:" + getMilk(10, 3) + "change");

// var guestList = ["A", "B", "C", "D"];
// var guestName = prompt("enter your name");
// if (guestList.includes(guestName)) {
//     alert("Welcome!");
// } else {
//     alert("Sorry,maybe next time");
// }
// var numberOfBottles = 99;
// while (numberOfBottles > 0) {
//     var bottleWord = "bottles";
//     if (numberOfBottles === 1) {
//         bottleWord = "bottle";
//     }
//     console.log(numberOfBottles + " " + bottleWord + " of beer on the wall");
//     console.log(numberOfBottles + " " + bottleWord + " of beer,");
//     console.log("Take one down, pass it around,");
//     numberOfBottles--;
//     console.log(numberOfBottles + " " + bottleWord + " of beer on the wall.");
// // }
// function fibonacciGenerator(n) {
//Do NOT change any of the code above 👆

//Write your code here:
//     var i;
//     var a = [];
//     if (n === 1) {
//         a = [0];
//     } else if (n === 2) {
//         a = [0, 1];
//     } else {
//         a = [0, 1];
//         for (var i = 0; i < n; i++) {
//             a.push(a[a.length - 1] + a[a.length - 2]);
//         }
//     }
//     return a;

//     //Return an array of fibonacci numbers starting from 0.

//     //Do NOT change any of the code below 👇
// }
// a = fibonacciGenerator(5);
// console.log(a);
