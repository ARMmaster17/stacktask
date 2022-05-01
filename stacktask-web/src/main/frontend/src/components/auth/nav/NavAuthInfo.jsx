import {useQuery} from "react-query";
import NavAuthenticatedInfo from "./NavAuthenticatedInfo";
import NavUnauthenticatedInfo from "./NavUnauthenticatedInfo";

export default function NavAuthInfo() {
    async function fetchUserAuthStatus() {
        const response = await fetch("/user/state");
        return response.json();
    }

    function NavAuthInfoData() {
        const {data, status} = useQuery('authenticated', fetchUserAuthStatus);
        if (status === 'loading') {
            return <div>Loading...</div>;
        }

        if (status === 'error') {
            return <div>Error!</div>;
        }

        if (data.authenticated) {
            return <NavAuthenticatedInfo />;
        } else {
            return <NavUnauthenticatedInfo />;
        }
    }

    return (
        <NavAuthInfoData />
    )
}