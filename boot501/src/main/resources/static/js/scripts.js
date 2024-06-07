document.querySelector(".clearBtn").addEventListener("click", function (e) {
    e.preventDefault()
    e.stopPropagation()
    self.location = "/board/list"

})

document.querySelector(".pagination").addEventListener("click", function (e) {
    e.preventDefault()
    e.stopPropagation()

    const target = e.target
    // a 태그 가 아니면 해당 클릭 이벤트 함수를 나간다.
    if (target.tagName !== 'A') {
        return
    }
    // tagName 전부 a 태그만 살아 남음.
    const num = target.getAttribute("data-num")

    // 추가, 검색 및 필터 관련 정보를 추가해서, 페이징 이동하기.
    const formObj = document.querySelector("form")
    formObj.innerHTML += `<input type="hidden" name="page" value="${num}">`
    formObj.submit()
    self.location = `/board/list?page=${num}`

}, false)