import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import EmployeeList from "../employee/EmployeeList";
import AddEmployee from "../employee/AddEmployee";

import "../../index.css";

export default function Header() {
  const HomePage = () => <h1 className="p-5">Home page</h1>;
  const DepartmentPage = () => <h1 className="p-5">Department</h1>;
  const SalaryPage = () => <h1 className="p-5">Salary</h1>;
  const EmployeePage = () => <EmployeeList />;
  const AddEmployeePage = () => <AddEmployee />;

  return (
    <Router>
      <nav className="navbar navbar-expand-lg bg-light">
        <div className="container-fluid">
          <a className="navbar-brand" href="/">
            <i className="bi bi-house"></i> Payroll
          </a>
          <button
            className="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarNav"
            aria-controls="navbarNav"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarNav">
            <ul className="navbar-nav">
              <li className="nav-item dropdown">
                <a
                  className="nav-link dropdown-toggle"
                  href="/employees"
                  id="employee"
                  role="button"
                  data-bs-toggle="dropdown"
                  aria-expanded="false"
                >
                  Employee
                </a>
                <ul className="dropdown-menu" aria-labelledby="navbarDropdown">
                  <li>
                    <a className="dropdown-item" href="/employees">
                      Employee List
                    </a>
                  </li>
                  <li>
                    <a className="dropdown-item" href="/addEmployee">
                      Add Employee
                    </a>
                  </li>
                </ul>
              </li>

              <li className="nav-item">
                <a className="nav-link" href="/department">
                  Department
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link " href="/salary">
                  Salary
                </a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <Routes>
        <Route path="/employees" element={<EmployeePage />}></Route>
        <Route path="/addEmployee" element={<AddEmployeePage />}></Route>
        <Route path="/department" element={<DepartmentPage />} />
        <Route path="/salary" element={<SalaryPage />} />
        <Route path="/" element={<HomePage />} />
      </Routes>
    </Router>
  );
}
