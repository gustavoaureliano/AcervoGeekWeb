const btnAdd = document.querySelector("#opcaoAdd");
const boxAdd = document.querySelector(".boxAdd");
const btnEdit = document.querySelector("#opcaoEdit");
const boxEdit = document.querySelector(".boxEdit");

btnAdd.addEventListener("click", () => {
    btnAdd.classList.add("selected");
    btnEdit.classList.remove("selected");
    boxAdd.classList.add("show");
    boxEdit.classList.remove("show");
});

btnEdit.addEventListener("click", () => {
    btnAdd.classList.remove("selected");
    btnEdit.classList.add("selected");
    boxAdd.classList.remove("show");
    boxEdit.classList.add("show");
})

const select = document.querySelector(".boxEdit .categorias")
const inputNomeCat = document.querySelector(".boxEdit .inputText");

select.addEventListener("change", () => {
    let text = document.querySelector(".boxEdit .categorias option:checked").text
    console.log(text);
    inputNomeCat.value = text;
});

const selectCat = document.querySelector(".searchBox .categorias");
const form = document.querySelector("#search");

selectCat.addEventListener("change", () => {
    form.click();
})