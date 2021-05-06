'use strict';

const firstName = document.querySelector("#firstName1");
const lastName = document.querySelector("#lastName1");
const benchPress = document.querySelector("#benchPress1");
const cleanAndJ = document.querySelector("#cleanAndJ1");
const snatch = document.querySelector("#snatch1");
const results = document.querySelector("#results");

const API_URL = "http://localhost:8080";

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

axios.get(`${API_URL}/getAll`, {
    headers: {'Access-Control-Allow-Origin': "*"}
})
    .then((response)=>{
        console.log(response);
        for(let data of response.data){
            printToScreen(data);
        }
    })
    .catch((err) =>{
        console.error(err);
    });

    const printToScreen = (information) => {
      
        const p = document.createElement("p");
        
        const text = document.createTextNode(`${information.firstName}, ${information.lastName}, ${information.benchPress} ${information.cleanAndJ} ${information.snatch}`);
      
        p.appendChild(text);
    
        results.appendChild(p);
    }

    



