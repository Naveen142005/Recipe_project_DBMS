document.querySelector('.recipe_3').addEventListener('mouseover', function () {
    document.querySelector('.recipe_1').style.width = '16.5em';
    document.querySelector('.recipe_1').style.height = '16.5em';
    document.querySelector('.recipe_2').style.width = '16.5em';
    document.querySelector('.recipe_2').style.height = '16.5em';

});

document.querySelector('.recipe_3').addEventListener('mouseout', function () {
    document.querySelector('.recipe_1').style.width = '';
    document.querySelector('.recipe_2').style.width = '';
    document.querySelector('.recipe_2').style.height = '';
    document.querySelector('.recipe_1').style.height = '';
});



function fun() {
    const form = document.getElementById('add_new_form');
    console.log("hello")
    form.classList.remove('none');
    form.classList.add('there');
}
document.querySelector('.y').addEventListener('click', () => {
    form.classList.remove('there');
    form.classList.add('none');
})
document.querySelector('.login').addEventListener('click', () => {
    window.location.href = "/recipes/login"
})


function f(event, nxt) {
    if (event.key === "Enter") {
        event.preventDefault();
        if (nxt) {
            document.getElementById(nxt).focus();
        }
    }
}





const btn = document.getElementById('submitbtn')
console.log(btn)

btn.addEventListener('click', () => {

    let title = document.getElementById('title').value;
    let description = document.getElementById('descrip').value;
    let prepTime = document.getElementById('prepTime').value;
    let cookTime = document.getElementById('cookTime').value;
    let mainIngredient = document.getElementById('mainIngredient').value;
    let instructions = document.getElementById('instructions').value
    let imageFile = document.getElementById('image').files[0];

    console.log("Title: ", title);
    console.log("Description: ", description);
    console.log("Preparation Time: ", prepTime);
    console.log("Cooking Time: ", cookTime);
    console.log("Main Ingredient: ", mainIngredient);
    console.log("Instructions: ", instructions);
    console.log("Image file: ", imageFile);

    let totalTime = prepTime + cookTime;

   // window.location.href = "http://localhost:8080/add"

    const pro = (imageFile) => {
        return new Promise((resolve, reject) => {
            const reader = new FileReader()

            reader.onload = () => {
                resolve(reader.result)
            }
            reader.onerror = () => {
                reject(new Error("Error reading file")); 
            };

            reader.readAsDataURL(imageFile)
        })
    }

    const obj = { title, description, prepTime, cookTime, totalTime, mainIngredient, instructions }

    const sendData = async (imageFile, obj) => {
       await pro(imageFile)
            .then(async res => {
               await fetch('http://localhost:8080/add', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify({
                        recipe_data: obj,   
                        image: res  
                    })
                })
                .then(isTrue => {
                   if (isTrue) alert("SuccessFully added")
                    else alert ("False")
                })
                .catch("Not added");
            })
    }
    sendData(imageFile, obj).catch(e => console.log("e")
    )
})