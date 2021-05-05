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

axios.get("http://localhost:8080/getAll")
    .then((response)=>{
        console.log(response);
        for(let data of response.data.data){
            printToScreen(data);
        }
    })
    .catch((err) =>{
        console.error(err);
    });

    const printToScreen = (information) => {
      
        const p = document.createElement("p");
        
        const text = document.createTextNode(`${information.firstNameVal} ${information.lastNameVal} ${information.benchPressVal} ${information.cleanAndJVal} ${information.snatchVal}`);
      
        p.appendChild(text);
    
        results.appendChild(p);
    }

    



