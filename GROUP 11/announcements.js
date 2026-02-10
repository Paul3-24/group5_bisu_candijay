// Initialize with sample announcements
const initializeAnnouncements = () => {
    const announcements = localStorage.getItem('announcements');
    if (!announcements) {
        const sampleData = [
            {
                id: 1,
                title: 'Opening Ceremony Schedule',
                content: 'The intramurals opening ceremony will be held on January 27, 2026 at 8:00 AM.',
                date: '2026-01-27'
            },
            {
                id: 2,
                title: 'Basketball Tournament Updates',
                content: 'All basketball games have been rescheduled to the new gymnasium.',
                date: '2026-01-27'
            },
            {
                id: 3,
                title: 'Volleyball Registration',
                content: 'Registration for volleyball tryouts is now open. Deadline is January 29, 2026.',
                date: '2026-01-27'
            },
            {
                id: 4,
                title: 'Important Reminder',
                content: 'Please bring your ID cards during event participation.',
                date: '2026-01-30'
            }
        ];
        localStorage.setItem('announcements', JSON.stringify(sampleData));
    }
};

// Load and display announcements
const loadAnnouncements = () => {
    const announcements = JSON.parse(localStorage.getItem('announcements') || '[]');
    const announcementsList = document.getElementById('announcementsList');
    
    // Sort by date (newest first)
    announcements.sort((a, b) => new Date(b.date) - new Date(a.date));
    
    if (announcements.length === 0) {
        announcementsList.innerHTML = '<div class="empty-state">No announcements yet. Click "Add Announcement" to create one.</div>';
        return;
    }
    
    announcementsList.innerHTML = announcements.map(announcement => {
        const announcementDate = new Date(announcement.date);
        const formattedDate = announcementDate.toLocaleDateString('en-US', { 
            month: 'short', 
            day: 'numeric', 
            year: 'numeric' 
        });
        
        return `
            <div class="announcement-card">
                <div class="announcement-header">
                    <h3>${announcement.title}</h3>
                    <span class="announcement-date">${formattedDate}</span>
                </div>
                <p class="announcement-content">${announcement.content}</p>
                <button class="btn-delete-small" onclick="deleteAnnouncement(${announcement.id})">Delete</button>
            </div>
        `;
    }).join('');
};

// Delete announcement
window.deleteAnnouncement = (id) => {
    if (confirm('Are you sure you want to delete this announcement?')) {
        const announcements = JSON.parse(localStorage.getItem('announcements') || '[]');
        const updatedAnnouncements = announcements.filter(a => a.id !== id);
        localStorage.setItem('announcements', JSON.stringify(updatedAnnouncements));
        loadAnnouncements();
    }
};

// Modal functionality
const modal = document.getElementById('announcementModal');
const addAnnouncementBtn = document.getElementById('addAnnouncementBtn');
const closeModal = document.querySelector('.close-modal');

addAnnouncementBtn.addEventListener('click', () => {
    modal.style.display = 'flex';
});

closeModal.addEventListener('click', () => {
    modal.style.display = 'none';
});

window.addEventListener('click', (e) => {
    if (e.target === modal) {
        modal.style.display = 'none';
    }
});

// Add announcement form
document.getElementById('announcementForm').addEventListener('submit', (e) => {
    e.preventDefault();
    
    const announcements = JSON.parse(localStorage.getItem('announcements') || '[]');
    const newAnnouncement = {
        id: announcements.length > 0 ? Math.max(...announcements.map(a => a.id)) + 1 : 1,
        title: document.getElementById('announcementTitle').value,
        content: document.getElementById('announcementContent').value,
        date: new Date().toISOString().split('T')[0]
    };
    
    announcements.push(newAnnouncement);
    localStorage.setItem('announcements', JSON.stringify(announcements));
    
    modal.style.display = 'none';
    document.getElementById('announcementForm').reset();
    loadAnnouncements();
});

// Initialize
initializeAnnouncements();
loadAnnouncements();