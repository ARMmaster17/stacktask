export default function OrganizationCard({organization}) {
    return (
        <div>
            <p>{organization.name} - Owned by {organization.owner.username}</p>
        </div>
    )
}