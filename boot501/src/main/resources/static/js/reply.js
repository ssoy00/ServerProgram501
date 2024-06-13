async function getTest(bno) {
    const result = await axios.get(`/replies/list/${bno}`)
    // console.log("result 확인 : " + result)
    // 데이터 확인용
    // return result.data
    return result
}