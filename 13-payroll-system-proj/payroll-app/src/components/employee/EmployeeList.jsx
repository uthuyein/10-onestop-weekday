import { useEffect, useState } from "react";
import Api from "../../services/Api";

const EmployeeList = () => {
  const [employees, setEmployee] = useState([]);
  const [loading, setLoading] = useState([]);

  useEffect(() => {
    Api.get("/employees")
      .then((response) => {
        setEmployee(response.data);
        setLoading(false);
      })
      .catch((error) => {
        console.error("Error Fetching Employee", error);
        setLoading(false);
      });
  }, []);

  if (loading) return <p>Loading Employees ......</p>;

  return (
    <div className="p-5">
      <h2 className="text-2xl font-bold mb-4">Employee List</h2>
      <table className="table">
        <thead>
          <tr>
            <th className="col"></th>
            <th className="col">Department</th>
            <th className="col">Employee</th>
            <th className="col">Date of birth</th>
          </tr>
        </thead>
        <tbody>
          {employees.map((emp) => (
            <tr key={emp.id}>
              <td className="col">1</td>
              <td className="col">{emp.department}</td>
              <td className="col">{emp.employee}</td>
              <td className="col">{emp.dob}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};
export default EmployeeList;
