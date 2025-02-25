const onFindAll = async () =>{
try{
const response = await axios.get('/doctor')
    const tbody = document.querySelector('tbody')
    let html='';
    response.data.forEach(doctor =>{
        html += `
            <tr>
                <td>${doctor.doctorid}</td>
                <td>${doctor.name}</td>
                <td>${doctor.specialty}</td>
                <td>${doctor.phone}</td>
                <td>
                <button onclick="onupdatepage(${doctor.doctorid})">수정</button>
                <button onclick="onDelete(${doctor.doctorid})">삭제</button>
                </td>
            </tr>`
    })
    tbody.innerHTML = html
    }catch(e){console.log(e)}
}
onFindAll();

const onupdatepage = async (doctorid) =>{
    location.href = `/main/updatedoctor.html?doctorid=${doctorid}`
}

const onDelete = async (doctorid) =>{
    const response = await axios.delete(`/doctor?doctorid=${doctorid}`)
    if(response.data ==1){onFindAll()}
}
const onSavepage = async () =>{
     location.href = `/main/savedoctor.html`
}