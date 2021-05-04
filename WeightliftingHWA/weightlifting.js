'use strict';

const firstName = document.querySelector("#firstName1");
const lastName = document.querySelector("#lastName1");
const benchPress = document.querySelector("#benchPress1");
const cleanAndJ = document.querySelector("#cleanAndJ1");
const snatch = document.querySelector("#snatch1");
const results = document.querySelector("#results");

// console.log(firstName.value);
// console.log(lastName.value);
// console.log(benchPress.value);
// console.log(cleanAndJ.value);
// console.log(snatch.value);


const createPersonalBest=() =>{
    const firstNameVal = firstName.value;
    const lastNameVal = lastName.value;
    const benchPressVal = benchPress.value;
    const cleanAndJVal = cleanAndJ.value;
    const snatchVal = snatch.value;
    const kilos = "KG";

    console.log(`${firstNameVal} ${lastNameVal} ${benchPressVal} ${cleanAndJVal} ${snatchVal}`);
};

