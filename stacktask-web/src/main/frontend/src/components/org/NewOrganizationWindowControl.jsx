import {useState} from "react";
import Modal from "react-modal";
import NewOrganizationForm from "./NewOrganizationForm";

export default function NewOrganizationWindowControl() {
    const [modalIsOpen, setModalIsOpen] = useState(false);

    function openModal() {
        setModalIsOpen(true);
    }

    function closeModal() {
        setModalIsOpen(false);
    }

    return (
        <div>
            <button onClick={openModal}>
                New Organization
            </button>
            <Modal isOpen={modalIsOpen} onClose={closeModal}>
                <NewOrganizationForm onSubmit={closeModal} />
                <button onClick={closeModal}>Close</button>
            </Modal>
        </div>
    );
}