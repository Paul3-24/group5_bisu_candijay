// Initialize with sample data
const initializeLeaderboard = () => {
    const leaderboard = localStorage.getItem('leaderboard');
    if (!leaderboard) {
        const sampleData = [
            { college: 'COS', gold: 6, silver: 4, bronze: 2 },
            { college: 'CTE', gold: 6, silver: 3, bronze: 5 },
            { college: 'CBM', gold: 6, silver: 2, bronze: 1 },
            { college: 'CFMS', gold: 6, silver: 5, bronze: 3 }
        ];
        localStorage.setItem('leaderboard', JSON.stringify(sampleData));
    }
};

// Calculate total points (Gold=3, Silver=2, Bronze=1)
const calculatePoints = (gold, silver, bronze) => {
    return gold + silver + bronze;
};

// Load and display leaderboard
const loadLeaderboard = (editable = false) => {
    const leaderboard = JSON.parse(localStorage.getItem('leaderboard') || '[]');
    const tbody = document.getElementById('leaderboardBody');
    
    // Sort by total points
    leaderboard.sort((a, b) => {
        const pointsA = calculatePoints(a.gold, a.silver, a.bronze);
        const pointsB = calculatePoints(b.gold, b.silver, b.bronze);
        return pointsB - pointsA;
    });
    
    tbody.innerHTML = leaderboard.map((item, index) => {
        const totalPoints = calculatePoints(item.gold, item.silver, item.bronze);
        
        if (editable) {
            return `
                <tr>
                    <td>${item.college}</td>
                    <td><input type="number" class="edit-input" data-index="${index}" data-field="gold" value="${item.gold}" min="0"></td>
                    <td><input type="number" class="edit-input" data-index="${index}" data-field="silver" value="${item.silver}" min="0"></td>
                    <td><input type="number" class="edit-input" data-index="${index}" data-field="bronze" value="${item.bronze}" min="0"></td>
                    <td>${totalPoints}</td>
                </tr>
            `;
        } else {
            return `
                <tr>
                    <td>${item.college}</td>
                    <td>${item.gold}</td>
                    <td>${item.silver}</td>
                    <td>${item.bronze}</td>
                    <td>${totalPoints}</td>
                </tr>
            `;
        }
    }).join('');
};

// Edit mode
let isEditing = false;
const editBtn = document.getElementById('editBtn');
const saveBtn = document.getElementById('saveBtn');

editBtn.addEventListener('click', () => {
    isEditing = true;
    loadLeaderboard(true);
    editBtn.style.display = 'none';
    saveBtn.style.display = 'inline-block';
});

saveBtn.addEventListener('click', () => {
    const leaderboard = JSON.parse(localStorage.getItem('leaderboard') || '[]');
    const inputs = document.querySelectorAll('.edit-input');
    
    inputs.forEach(input => {
        const index = parseInt(input.dataset.index);
        const field = input.dataset.field;
        const value = parseInt(input.value) || 0;
        leaderboard[index][field] = value;
    });
    
    localStorage.setItem('leaderboard', JSON.stringify(leaderboard));
    
    isEditing = false;
    loadLeaderboard(false);
    saveBtn.style.display = 'none';
    editBtn.style.display = 'inline-block';
});

// Initialize
initializeLeaderboard();
loadLeaderboard();
