import {useQuery} from "react-query";
import OrganizationCard from "../components/org/OrganizationCard";
import NewOrganizationWindowControl from "../components/org/NewOrganizationWindowControl";

export default function Organizations() {
    const fetchOrganizations = async () => {
        const response = await fetch('/api/organization/all');
        return response.json();
    }

    const {data, status} = useQuery(
        ["organzations"],
        fetchOrganizations
    );

    if (status === "loading") {
        return <div>Loading...</div>;
    }

    if (status === "error") {
        return <div>Error</div>;
    }

    return (
        <div>
            {data.map((organization) => (
                <OrganizationCard organization={organization} />
            ))}
            <NewOrganizationWindowControl />
        </div>
    );
}