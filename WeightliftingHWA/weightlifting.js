'use strict';

const firstName = document.querySelector("#firstName1");
const lastName = document.querySelector("#lastName1");
const benchPress = document.querySelector("#benchPress1");
const cleanAndJ = document.querySelector("#cleanAndJ1");
const snatch = document.querySelector("#snatch1");

const updateId = document.querySelector("#updateId");
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

            const row = `<tr class="table-dark">
                                <td> ${data[i].firstName} </td>
                                <td> ${data[i].lastName} </td>
                                <td> ${data[i].benchPress} </td>
                                <td> ${data[i].cleanAndJ} </td>
                                <td> ${data[i].snatch} </td>
                                <td> <button type="button" class="btn btn-outline-info btn-sm" data-bs-toggle="modal" data-bs-target="#exampleModal2${data[i].id}">
                                Change this PR!
                              </button>
                              
                              
                              
                              <!-- Modal -->
                              <div class="modal fade" id="exampleModal2${data[i].id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                        
                                            <h5 class="modal-title" id="exampleModalLabel">Change your PR!</h5>
                                            <button type="button" class="btn-close btn-danger" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <input type="text" class="form-control" id="updateId${data[i].id}" value=${data[i].id} disabled/>
                                            <input type="text" class="form-control" id="firstName2${data[i].id}" placeholder="First Name:" value=${data[i].firstName} />
                                            <input type="text" class="form-control" id="lastName2${data[i].id}" placeholder="Last Name:" value=${data[i].lastName} />
                                            <input type="number" class="form-control" id="benchPress2${data[i].id}" placeholder="Bench Press:" value=${data[i].benchPress} />
                                            <input type="number" class="form-control" id="cleanAndJ2${data[i].id}" placeholder="Clean and Jerk:" value=${data[i].cleanAndJ} />
                                            <input type="number" class="form-control" id="snatch2${data[i].id}" placeholder="Snatch:" value=${data[i].snatch} />
                              
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-danger" data-bs-dismiss="modal" onclick="deletePersonalBest(${data[i].id});" >Delete!</button>
                                            <button type="button" class="btn btn-success" data-bs-dismiss="modal" onclick="updatePersonalBest(${data[i].id});">Update!</button>
                                        </div>
                                    </div>
                                </div>
                              </div></td>
                                
            
            </tr>`

            table.innerHTML +=row;

        }   
       
    }


    const updatePersonalBest=(number) =>{

        const firstNameUpdate = document.querySelector("#firstName2" + number);
        const lastNameUpdate = document.querySelector("#lastName2" + number);
        const benchPressUpdate = document.querySelector("#benchPress2" + number);
        const cleanAndJUpdate = document.querySelector("#cleanAndJ2" + number);
        const snatchUpdate = document.querySelector("#snatch2" +number);

      
        
        const firstNameVal = firstNameUpdate.value;
        const lastNameVal = lastNameUpdate.value;
        const benchPressVal = benchPressUpdate.value;
        const cleanAndJVal = cleanAndJUpdate.value;
        const snatchVal = snatchUpdate.value;
        
        
    
        let obj2 = {

            
            firstName: firstNameVal,
            lastName: lastNameVal,
            benchPress: benchPressVal,
            cleanAndJ: cleanAndJVal,
            snatch: snatchVal
        };
    
        
    
        axios
        .put(`${API_URL}/update/${number}`,obj2 )
        .then((resp) => {
            console.log(resp);
            ALERT.setAttribute("class", "alert alert-success");
            ALERT.innerHTML = "Record has been successfully updated! Please wait a moment";
    
    
            setTimeout( () => {
                ALERT.removeAttribute("class");
                ALERT.innerHTML = "";
                location.reload();
            },1500);
        })
        .catch((err) => console.error(err));
    }


   const deletePersonalBest= (number) =>{


    console.log(number); 
    axios
    .delete(`${API_URL}/remove/${number}`,{
        headers: {'Access-Control-Allow-Origin': "*"}
    })
    .then((resp) => {
        console.log(resp);
        ALERT.setAttribute("class", "alert alert-success");
        ALERT.innerHTML = "Record has been deleted! Please wait a moment";


        setTimeout( () => {
            ALERT.removeAttribute("class");
            ALERT.innerHTML = "";
            location.reload();
        },1500);
    })
    .catch((err) => console.error(err));

   }
   
     

