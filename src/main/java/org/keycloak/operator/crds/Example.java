/**
 * Copyright 2021 Red Hat, Inc. and/or its affiliates.
 *
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package org.keycloak.operator.crds;

import io.sundr.adapter.api.AdapterContext;
import io.sundr.adapter.api.Adapters;
import io.sundr.builder.TypedVisitor;
import io.sundr.model.PropertyBuilder;
import io.sundr.model.TypeDef;
import io.sundr.model.TypeDefBuilder;
import io.sundr.model.utils.Types;

import javax.lang.model.element.Modifier;
import java.util.Collections;

public class Example {

    public static void main(String[] args) {
        System.out.println("From here");


        TypeDef realm = Adapters.adaptType(org.keycloak.representations.idm.RealmRepresentation.class, AdapterContext.getContext());
        TypeDef dto = new TypeDefBuilder(realm)
                .withName(realm.getName() + "DTO")
                .withMethods(Collections.emptyList())
                .withConstructors(Collections.emptyList())
                .withExtendsList(Collections.emptyList())
                .accept(new TypedVisitor<PropertyBuilder>() {
                    public void visit(PropertyBuilder property) {
                        System.out.println("property " + property.getName());

                        System.out.println(property.getTypeRef());

                        property.withModifiers(Types.modifiersToInt(Modifier.PUBLIC));
                    }
                })
                .build();
        System.out.println(dto.render());

    }

}
