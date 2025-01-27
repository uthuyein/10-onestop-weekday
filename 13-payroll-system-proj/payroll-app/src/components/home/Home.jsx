
export default function Header(){
    return (
        <nav className="navbar navbar-expand-lg bg-light">
  <div className="container-fluid">
    <a className="navbar-brand" href="#"><i className="bi bi-house"></i> Payroll</a>
    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span className="navbar-toggler-icon"></span>
    </button>
    <div className="collapse navbar-collapse" id="navbarNav">
      <ul className="navbar-nav">
        <li className="nav-item">
          <a className="nav-link" href="#">Employee</a>
        </li>
        <li className="nav-item">
          <a className="nav-link" href="#">Department</a>
        </li>
        <li className="nav-item">
          <a className="nav-link " href="#">Salary</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
    );
}

