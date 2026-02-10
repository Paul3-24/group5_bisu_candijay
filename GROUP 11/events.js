// Initialize with sample events
const initializeEvents = () => {
    const events = localStorage.getItem('events');
    if (!events) {
        const sampleEvents = [
            {
                id: 1,
                name: "Men's Basketball",
                category: "sports",
                type: "Event",
                dateTime: "2026-01-26T13:00",
                location: "Gym",
                maxParticipants: 30,
                currentParticipants: 0,
                description: "This event is open to all students who want to showcase their skills and potentially join the college basketball team."
            },
            {
                id: 2,
                name: "Women's Volleyball",
                category: "sports",
                dateTime: "2026-01-28T14:00",
                location: "Court",
                maxParticipants: 24,
                currentParticipants: 0,
                description: "Show us your serving, spiking, and teamwork skills. All skill levels welcome!"
            }
        ];
        localStorage.setItem('events', JSON.stringify(sampleEvents));
    }
};

// Load and display events
const loadEvents = (filter = 'all') => {
    const events = JSON.parse(localStorage.getItem('events') || '[]');
    const eventsGrid = document.getElementById('eventsGrid');
    
    // Filter events
    const filteredEvents = filter === 'all' 
        ? events 
        : events.filter(event => event.category === filter);
    
    // Update counts
    document.getElementById('allCount').textContent = events.length;
    document.getElementById('sportsCount').textContent = events.filter(e => e.category === 'sports').length;
    document.getElementById('literaryCount').textContent = events.filter(e => e.category === 'literary').length;
    
    // Display events
    if (filteredEvents.length === 0) {
        eventsGrid.innerHTML = '<div class="empty-state">No events found. Click "Add New" to create an event.</div>';
        return;
    }
    
    eventsGrid.innerHTML = filteredEvents.map(event => {
        const eventDate = new Date(event.dateTime);
        const formattedDate = eventDate.toLocaleDateString('en-US', { 
            month: 'short', 
            day: 'numeric', 
            year: 'numeric' 
        });
        const formattedTime = eventDate.toLocaleTimeString('en-US', { 
            hour: 'numeric', 
            minute: '2-digit',
            hour12: true 
        });
        
        return `
            <div class="event-card">
                <div class="event-header"></div>
                <div class="event-body">
                    <h3 class="event-name">${event.name}</h3>
                    <p class="event-detail">${formattedDate} at ${formattedTime}</p>
                    <p class="event-detail">${event.location}</p>
                    <p class="event-detail">${event.currentParticipants}/${event.maxParticipants} slots filled</p>
                </div>
                <button class="btn-view-details" onclick="viewEventDetails(${event.id})">View Details</button>
            </div>
        `;
    }).join('');
};

// View event details
window.viewEventDetails = (eventId) => {
    const events = JSON.parse(localStorage.getItem('events') || '[]');
    const event = events.find(e => e.id === eventId);
    if (event) {
        const eventDate = new Date(event.dateTime);
        const formattedDate = eventDate.toLocaleDateString('en-US', { 
            month: 'long', 
            day: 'numeric', 
            year: 'numeric' 
        });
        const formattedTime = eventDate.toLocaleTimeString('en-US', { 
            hour: 'numeric', 
            minute: '2-digit',
            hour12: true 
        });
        
        // Populate modal with event details
        document.getElementById('detailEventName').textContent = event.name;
        document.getElementById('detailVenue').textContent = event.location;
        document.getElementById('detailDateTime').textContent = formattedDate;
        document.getElementById('detailSlots').textContent = `${event.currentParticipants}/${event.maxParticipants}`;
        
        const slotsAvailable = event.maxParticipants - event.currentParticipants;
        document.getElementById('detailSlotsAvailable').textContent = `${slotsAvailable} slots available`;
        
        // Set description
        document.getElementById('detailDescription').textContent = event.description || 'No description available';
        
        // Show the modal
        document.getElementById('eventDetailsModal').style.display = 'flex';
    }
};

// Modal functionality
const modal = document.getElementById('eventModal');
const addEventBtn = document.getElementById('addEventBtn');
const closeModal = document.querySelector('.close-modal');

addEventBtn.addEventListener('click', () => {
    modal.style.display = 'flex';
});

closeModal.addEventListener('click', () => {
    modal.style.display = 'none';
});

// Modal functionality for Event Details
const detailsModal = document.getElementById('eventDetailsModal');
const closeDetailsModal = document.getElementById('closeDetailsModal');

closeDetailsModal.addEventListener('click', () => {
    detailsModal.style.display = 'none';
});

window.addEventListener('click', (e) => {
    if (e.target === modal) {
        modal.style.display = 'none';
    }
    if (e.target === detailsModal) {
        detailsModal.style.display = 'none';
    }
});

// Add event form
document.getElementById('eventForm').addEventListener('submit', (e) => {
    e.preventDefault();
    
    const events = JSON.parse(localStorage.getItem('events') || '[]');
    const newEvent = {
        id: events.length > 0 ? Math.max(...events.map(e => e.id)) + 1 : 1,
        name: document.getElementById('eventName').value,
        type: 'EVENT',
        category: document.getElementById('eventCategory').value,
        dateTime: document.getElementById('eventDateTime').value,
        location: document.getElementById('eventLocation').value,
        maxParticipants: parseInt(document.getElementById('eventMaxParticipants').value),
        currentParticipants: 0,
        description: document.getElementById('eventDescription').value || 'No description provided'
    };
    
    events.push(newEvent);
    localStorage.setItem('events', JSON.stringify(events));
    
    modal.style.display = 'none';
    document.getElementById('eventForm').reset();
    
    // Reload with current filter
    const activeFilter = document.querySelector('.filter-tab.active').dataset.filter;
    loadEvents(activeFilter);
});

// Filter tabs
document.querySelectorAll('.filter-tab').forEach(tab => {
    tab.addEventListener('click', (e) => {
        document.querySelectorAll('.filter-tab').forEach(t => t.classList.remove('active'));
        e.target.classList.add('active');
        loadEvents(e.target.dataset.filter);
    });
});

// Initialize
initializeEvents();
loadEvents();
