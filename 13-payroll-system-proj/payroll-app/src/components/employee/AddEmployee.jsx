import { useRef } from "react";

export default function AddEmployee({add}){

    const depRef = useRef ();
    const empRef = useRef();
    const dobRef = useRef();

    
    return (
        <form action="" className="form"
        onSubmit={ e => {
            e.preventDefault();
            const dep = depRef.current.value;
            const emp = empRef.current.value;
            const dob = dobRef.current.value;
            add(dep,emp,dob);
        }}
        >
         <select className="form-select" aria-label="Select Employee">
            <option selected>Open this select menu</option>
            <option value="1">One</option>
            <option value="2">Two</option>
            <option value="3">Three</option>
        </select>
        <div className="mb-3">
            <label htmlFor="exampleInputPassword1" className="form-label">Password</label>
            <input type="password" className="form-control" id="exampleInputPassword1"/>
        </div>
        <div className="mb-3 form-check">
            <input type="checkbox" className="form-check-input" id="exampleCheck1"/>
            <label className="form-check-label" htmlFor="exampleCheck1">Check me out</label>
        </div>
        <button type="submit" className="btn btn-primary">Submit</button>

        </form>
    );
}