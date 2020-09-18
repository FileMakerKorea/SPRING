function addEvent(element, eventName, cb, isCapture) {
	if(element) {
		element.addEventListener(eventName, cb, isCapture);
	}
}