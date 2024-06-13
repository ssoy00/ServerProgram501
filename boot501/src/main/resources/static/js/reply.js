async function getTest(bno) {
    const result = await axios.get(`/replies/list/${bno}`)
    // console.log("result 확인 : " + result)
    return result.data
}