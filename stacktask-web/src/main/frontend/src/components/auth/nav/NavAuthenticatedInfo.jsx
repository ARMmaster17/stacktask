import {Link} from "react-router-dom";

export default function NavAuthenticatedInfo() {
    const logout = (e) => {
        document.cookie = "quarkus-credential=; Max-Age=0;"
    }

    return (
        <Link to="/login" onClick={logout}>Log Out</Link>
    )
}