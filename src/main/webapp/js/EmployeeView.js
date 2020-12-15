import AbstractView from './AbstractView.js';

export default class EmployeeView extends AbstractView {
    constructor(params) {
        super(params);
        this.setTitle("ERS Reimbursement System - Employee");
    }

    displayHtml() {
        document.getElementById('navBar').setAttribute('display', 'block');
    }
}