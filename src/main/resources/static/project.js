document.querySelector('.recipe_3').addEventListener('mouseover', function() {
    document.querySelector('.recipe_1').style.width = '16.5em';
    document.querySelector('.recipe_1').style.height = '16.5em';
    document.querySelector('.recipe_2').style.width = '16.5em';
    document.querySelector('.recipe_2').style.height = '16.5em';
   
}); 

document.querySelector('.recipe_3').addEventListener('mouseout', function() {
document.querySelector('.recipe_1').style.width = ''; 
document.querySelector('.recipe_2').style.width = ''; 
document.querySelector('.recipe_2').style.height = '';
document.querySelector('.recipe_1').style.height = ''; 
});

const recipe1 = document.getElementById('recipe1')
const search = document.getElementById('searchInput')

recipe1.addEventListener("click",()=>{
    console.log("clicked")
    window.location.href = "/recipes/fish gravy"
})


const form = document.getElementById('add_new_form');
const btn = document.querySelector('addnew');

function fun(){
    console.log("hello")
    form.classList.remove('none');
    form.classList.add('there');
}
document.querySelector('.y').addEventListener('click',()=>{
    form.classList.remove('there');
    form.classList.add('none');
})
document.querySelector('.login').addEventListener('click',()=>{
    window.location.href = "/recipes/login"
})

function sum() {
    let num1 = parseInt(document.getElementById('prepTime').value);
    let num2 = parseInt(document.getElementById('cookTime').value);
    let sum_value = num1 + num2;
    document.getElementById('totalTime').value = sum_value;
}
function f(event,nxt){
    if(event.key == "Enter" && nxt !== null)
    event.preventDefault();
document.getElementById(nxt).focus();
}
search.addEventListener("keyup", function(event) {
    if (event.key === "Enter") {
        let recipe_name = document.getElementById('searchInput').value;
        window.location.href = '/recipes/' + recipe_name;
    }
});

function submitSearch(){
    let recipeName = document.getElementById('searchInput').value.trim();
    if (recipeName !== '') { 
        window.location.href = '/recipes/' + encodeURIComponent(recipeName); 
    } else {
        alert('Please enter a recipe name.'); 
}
}
function sumbit_fun(){
    const add = document.getElementById('add_success');
    add.classList.remove('none_submit');
    add.classList.add('there_submit');
}