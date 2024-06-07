document.getElementById('voteForm').addEventListener('submit', function (e) {
    e.preventDefault(); // Prevent the form from submitting the traditional way

    const constituencyName = document.getElementById('constituency').value;
    const partyName = document.getElementById('party').value;

    fetch(`http://localhost:8080/api/voting/vote?constituencyName=${encodeURIComponent(constituencyName)}&partyName=${encodeURIComponent(partyName)}`, {
        method: 'PUT',
    })
    .then(response => {
        if (response.ok) {
            return response.json();
        }
        throw new Error('Network response was not ok.');
    })
    .then(data => {
        document.getElementById('result').innerText = `Vote recorded for ${data.candidates.find(c => c.partyName === partyName).candidateName} in constituency ${constituencyName}`;
    })
    .catch(error => {
        console.error('Error:', error);
        document.getElementById('result').innerText = 'Failed to record the vote. Please try again.';
    });
});
