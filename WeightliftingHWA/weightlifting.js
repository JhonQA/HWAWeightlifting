'use strict';

const firstName = document.querySelector("#firstName1");
const lastName = document.querySelector("#lastName1");
const benchPress = document.querySelector("#benchPress1");
const cleanAndJ = document.querySelector("#cleanAndJ1");
const snatch = document.querySelector("#snatch1");
const ALERT = document.querySelector("#onSuccess");



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

   
   

    // console.log(`${firstNameVal} ${lastNameVal} ${benchPressVal} ${cleanAndJVal} ${snatchVal}`);



    let obj = {
        firstName: firstNameVal,
        lastName: lastNameVal,
        benchPress: benchPressVal,
        cleanAndJ: cleanAndJVal,
        snatch: snatchVal
    };

    

    axios
    .post(`${API_URL}/create`,obj)
    .then((resp) => {
        console.log(resp);
        ALERT.setAttribute("class", "alert alert-success");
        ALERT.innerHTML = "Record has been successfully created! Please wait a moment";


        setTimeout( () => {
            ALERT.removeAttribute("class");
            ALERT.innerHTML = "";
            location.reload();
        },3000);
    })
    .catch((err) => console.error(err));
}

var myArray = [];


axios.get(`${API_URL}/getAll`, {
    headers: {'Access-Control-Allow-Origin': "*"}
})
    .then((response)=>{
       myArray = response.data;
       buildTable(myArray);
       console.log(myArray); 
    })
    .catch((err) =>{
        console.error(err);
    });

    const buildTable = (data) => {
      
        const table = document.getElementById(`myTable`);

        for(var i =0; i< data.length; i++){

            const row = `<tr>
                                <td> ${data[i].firstName} </td>
                                <td> ${data[i].lastName} </td>
                                <td> ${data[i].benchPress} </td>
                                <td> ${data[i].cleanAndJ} </td>
                                <td> ${data[i].snatch} </td>
                                <td> 
                                <button type="button" class="btn btn-link">Delete</button></td>
            
            </tr>`

            table.innerHTML +=row;

        }
       
    }

   
    





    // , ${information.lastName}, ${information.benchPress} ${information.cleanAndJ} ${information.snatch}

