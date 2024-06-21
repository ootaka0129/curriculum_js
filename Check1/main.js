let numbers = [2, 5, 12, 13, 15, 18, 22];

for (let i = 0; i < numbers.length; i++) {
    isEven(numbers[i]);
}

function isEven(num) {
    if (num % 2 === 0) {
        console.log(num + 'は偶数です');
    }
}



class Car {
    constructor(gas, number) {
        this.gas = gas;
        this.number= number;
    }
    getNumGas() {
        console.log(`ガソリンは${this.gas}です。ナンバーは${this.number}です。`);
    }
}

let ACar = new Car('満タン','1111');
ACar.getNumGas();