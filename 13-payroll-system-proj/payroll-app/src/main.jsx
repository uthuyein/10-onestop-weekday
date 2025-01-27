import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';
import 'bootstrap-icons/font/bootstrap-icons.css';
import EmployeeList from "./components/employee/EmployeeList";

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <EmployeeList />
  </StrictMode>,
)
