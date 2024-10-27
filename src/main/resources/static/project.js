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


const form = document.getElementById('add_new_form');


function fun() {
    console.log("hello")
    form.classList.remove('none');
    form.classList.add('there');
}
const x = document.getElementById('cross')
console.log(x);

x.addEventListener('click', () => {
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

btn.addEventListener('click', (event) => {
    event.preventDefault();

    let title = document.getElementById('title');
    let description = document.getElementById('descrip');
    let prepTime = document.getElementById('prepTime');
    let cookTime = document.getElementById('cookTime');
    let mainIngredient = document.getElementById('mainIngredient');
    let instructions = document.getElementById('instructions')
    let imageFile = document.getElementById('image');


    let totalTime = prepTime.value + cookTime.value;

    const formData = new FormData();
    formData.append("title", title.value);
    formData.append("description", description.value);
    formData.append("prepTime", Number(prepTime.value));
    formData.append("cookTime", Number(cookTime.value));
    formData.append("totalTime", totalTime);
    formData.append("mainIngredient", mainIngredient.value);
    formData.append("instructions", instructions.value);
    formData.append("imageFile", imageFile.files[0]);

    fetch("http://localhost:8080/add" , {
        method:"POST",
        body:formData
    })
    .then(res => {
        if (res.ok) return res.json();
        else throw new Error("Server error");
    })
    .then(isTrue => {
        if(isTrue) {
            const Successbtn = document.getElementById('add_success');
            const green = document.getElementById('green');
            green.classList.add('border');
            Successbtn.classList.remove('none_submit');
            title.value =""
            description.value =""
            prepTime.value =""
            cookTime.value =""
            mainIngredient.value =""
            instructions.value =""
            setTimeout(()=>{
                const Successbtn_ = document.getElementById('add_success');
                const green_ = document.getElementById('green');
                green_.classList.add('remove');
                Successbtn_.classList.add('none_submit');
            }  , 1000)
        }
        else {
            alert("Not Success !!")
        }
    })
    .catch(e => {
        alert("ERROR")
        console.log(e);
    })
})