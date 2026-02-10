// Initialize with sample data
const initializeParticipants = () => {
    const participants = localStorage.getItem('participants');
    if (!participants) {
        const sampleData = [
            { id: 1, name: 'John Paul', gender: 'Male', email: 'johnpaulgamo@bisu.edu.ph', age: 21 }
        ];
        localStorage.setItem('participants', JSON.stringify(sampleData));
    }
};

// Load and display participants
const loadParticipants = (searchTerm = '') => {
    const participants = JSON.parse(localStorage.getItem('participants') || '[]');
    const tbody = document.getElementById('participantsBody');
    
    // Filter participants based on search
    const filteredParticipants = participants.filter(participant => {
        const searchLower = searchTerm.toLowerCase();
        return (
            participant.name.toLowerCase().includes(searchLower) ||
            participant.email.toLowerCase().includes(searchLower) ||
            participant.age.toString().includes(searchLower)
        );
    });
    
    if (filteredParticipants.length === 0) {
        tbody.innerHTML = '<tr><td colspan="5" class="empty-state">No participants found</td></tr>';
        return;
    }
    
    tbody.innerHTML = filteredParticipants.map(participant => `
        <tr>
            <td>${participant.name}</td>
            <td>${participant.gender}</td>
            <td>${participant.email}</td>
            <td>${participant.age}</td>
            <td>
                <button class="btn-action" onclick="viewParticipant(${participant.id})">View</button>
                <button class="btn-action btn-delete" onclick="deleteParticipant(${participant.id})">Delete</button>
            </td>
        </tr>
    `).join('');
};

// View participant details
window.viewParticipant = (id) => {
    const participants = JSON.parse(localStorage.getItem('participants') || '[]');
    const participant = participants.find(p => p.id === id);
    if (participant) {
        alert(`Name: ${participant.name}\nGender: ${participant.gender}\nEmail: ${participant.email}\nAge: ${participant.age}`);
    }
};

// Delete participant
window.deleteParticipant = (id) => {
    if (confirm('Are you sure you want to delete this participant?')) {
        const participants = JSON.parse(localStorage.getItem('participants') || '[]');
        const updatedParticipants = participants.filter(p => p.id !== id);
        localStorage.setItem('participants', JSON.stringify(updatedParticipants));
        loadParticipants(document.getElementById('searchInput').value);
    }
};

// Search functionality
document.getElementById('searchInput').addEventListener('input', (e) => {
    loadParticipants(e.target.value);
});

// Initialize
initializeParticipants();
loadParticipants();
