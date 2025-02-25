const onFindAll = async () =>{
try{
const response = await axios.get('/patient')
    const tbody = document.querySelector('tbody')
    let html='';
    response.data.forEach(patient =>{
        html += `
            <tr>
                <td>${patient.patientid}</td>
                <td>${patient.name}</td>
                <td>${patient.phone}</td>
                <td>
                <button onclick="onupdatepage(${patient.patientid})">수정</button>
                <button onclick="onDelete(${patient.patientid})">삭제</button>
                </td>
            </tr>`
    })
    tbody.innerHTML = html
    }catch(e){console.log(e)}
}
onFindAll();

const onupdatepage = async (patientid) =>{
    location.href = `/main/updatepatient.html?patientid=${patientid}`
}

const onDelete = async (patientid) =>{
    const response = await axios.delete(`/patient?patientid=${patientid}`)
    if(response.data ==1){onFindAll()}
}
const onSavepage = async () =>{
     location.href = `/main/savepatient.html`
}