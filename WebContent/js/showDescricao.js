const itens = document.querySelectorAll(".listItens .item .content");
const btnsClose = document.querySelectorAll(".back .btn");
const btnsExluir = document.querySelectorAll(".btn.showExcluir");

itens.forEach(item => {
    item.addEventListener("click", e => {
        let back = e.target.closest(".item").lastElementChild;
        console.log(back);
        back.classList.add("show");
    }, true)
});

btnsClose.forEach(btn => {
    btn.addEventListener("click", e => {
        let back = e.target.closest(".back");
        console.log(back);
        back.classList.remove("show");
    })
});

btnsExluir.forEach(item => {
    item.addEventListener("click", e => {
        let back = e.target.closest(".alterar").lastElementChild;
        back.classList.add("show");
    })
});

const btnDesc = document.querySelectorAll(".sobreDesc");

btnDesc.forEach(btn => {
    btn.addEventListener("click", e => {
        let desc = e.target.closest(".sobreDesc").parentElement.lastElementChild;
        console.log(desc);
        desc.classList.add("show");
    }, true)
});

const btnCat = document.querySelectorAll("#btnCat");

btnCat.forEach(btn => {
    btn.addEventListener("click", e => {
        let categoria = e.target.closest(".boxCat").lastElementChild;
        console.log(categoria);
        categoria.classList.add("show");
    }, true)
});

