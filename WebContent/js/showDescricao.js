const itens = document.querySelectorAll(".listItens .item")
const btnsClose = document.querySelectorAll(".desc .btn")

itens.forEach(item => {
    item.addEventListener("click", e => {
        let desc = e.target.closest(".item").lastElementChild;
        console.log(desc);
        desc.classList.add("show");
    }, true)
});

btnsClose.forEach(btn => {
    btn.addEventListener("click", e => {
        let desc = e.target.closest(".desc");
        console.log(desc);
        desc.classList.remove("show");
    })
});