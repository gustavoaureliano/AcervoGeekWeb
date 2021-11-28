const listItens = document.querySelector(".listItens");
const btnAlt = document.querySelector(".opcao.alt");

btnAlt.addEventListener("click", () => {
    listItens.classList.toggle("edit");
})