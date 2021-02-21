const icon=document.querySelector("i");
const search=document.querySelector('input');

search.addEventListener("focusin",(event)=>{
    icon.classList.remove('fa-translate-back');
    icon.classList.add('fas-translate');
});
search.addEventListener("focusout",(event)=>{
    icon.classList.remove('translate');
    icon.classList.add('fa-translate-back');
});