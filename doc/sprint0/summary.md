# Summary

## Objective

Build a medical resource management system that stores and manages visual assessment records for optometrists and patients in Toronto.
The system enables optometrists to record patient assessments and securely share these records with other healthcare professionals as needed.

## Key Personas

- **Optometrist:** Jason Ha, A licensed optometrist registered in the Toronto Professional Services List (PSL), responsible for conducting and recording visual assessments.
Optometrists use the system to document patient assessment results and securely share these records with other healthcare professionals as needed.

- **Patient:** Damian Brathwaite, an individual receiving visual assessments from registered optometrists in Toronto.
Patients have access to their medical records, linked to assessments conducted by their optometrists.
They can use these records when obtaining prescriptions or receiving services, such as purchasing glasses.

## Key Scenarios

- **Scenario #1:** An optometrist conducts a full visual assessment on a patient. The optometrist can register the patient (if necessary) and create, read, update, and delete medical records associated with the patient.

- **Scenario #2:** A patient logs into the system to view their medical history. Patients are authorized only to view records, not to create or modify any resources.

## Key Principles

- **Patient Privacy:** The system prioritizes the confidentiality of patient records, even if this may impact application workflow speed.
Any attempt by an optometrist to share patient records requires the associated patient’s confirmation through the portal.

- **Ease of Use:** Inspired by the application name "Catalyst," which refers to a substance that facilitates chemical reactions, this portal provides a minimalist interface to streamline administrative tasks for healthcare professionals.
The goal is to enable them to perform CRUD operations and resource sharing with minimal learning curve and effort.